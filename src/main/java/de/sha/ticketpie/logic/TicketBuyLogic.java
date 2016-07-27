package de.sha.ticketpie.logic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import de.sha.ticketpie.dto.BuyResultDto;
import de.sha.ticketpie.entity.Ticket;
import de.sha.ticketpie.entity.TicketSoldHistory;
import de.sha.ticketpie.repository.TicketRepository;
import de.sha.ticketpie.repository.TicketSoldHistoryRepository;

@Service
public class TicketBuyLogic {

	@Autowired
	TicketRepository ticketRepository;

	@Autowired TicketSoldHistoryRepository soldHistoryRepository;

	public BuyResultDto buyTicket() {

		// 1.未購入のチケット全件取得 idの若い順で良席とする
		List<Ticket> ticketStock = ticketRepository.findBySoldOutFlagOrderByIdAsc(false);
		// 1で結果が取得できた場合
		if (!ticketStock.isEmpty()) {
			Ticket ticket = ticketStock.get(0);
			ticket.setSoldOutFlag(true);
			ticket.setUpdateDateTime(new Date());
			try {
				// 2.未購入 -> 購入
				ticketRepository.save(ticket);

			} catch (OptimisticLockingFailureException ex) {
				// ロック発生時に再購入処理
				return buyTicket();
			}
			// 2で購入できた場合
			soldHistoryRepository.save(new TicketSoldHistory(ticket.getSeatNo()));
			return new BuyResultDto(true, ticket.getSeatNo());

		} else {
			// 1で結果が取得できなかった場合
			return new BuyResultDto(false, null);

		}
	}
}
