package de.sha.ticketpie.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.*;

import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import de.sha.ticketpie.TicketPieApplication;
import de.sha.ticketpie.entity.Ticket;
import de.sha.ticketpie.entity.TicketSoldHistory;
import de.sha.ticketpie.repository.TicketRepository;
import de.sha.ticketpie.repository.TicketSoldHistoryRepository;
import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketPieApplication.class)
@WebAppConfiguration
@IntegrationTest({ "server.port:0" })
public class BuyTest {

	@Autowired
	TicketRepository ticketRepo;

	@Autowired
	TicketSoldHistoryRepository historyRepo;

	@Value("${local.server.port}")
	int port;
	Ticket ticket1;
	Ticket ticket2;
	List<Ticket> tickets;
	RestTemplate restTemplate = new TestRestTemplate();

	@Before
	public void setup() {
		ticketRepo.deleteAll();
		ticket1 = new Ticket("A1", false);
		ticket2 = new Ticket("A2", false);
		tickets = Arrays.asList(ticket1, ticket2);
		ticketRepo.save(tickets);
		RestAssured.port = port;
	}

	@Test
	public void buyTest_normal_case() throws Exception {
		when().get("/buy")
			.then()
			.statusCode(HttpStatus.OK.value())
			.body("judgement", equalTo(true))
			.body("seatNo", equalTo("A1"));

		when().get("/buy")
		.then()
		.statusCode(HttpStatus.OK.value())
		.body("judgement", equalTo(true))
		.body("seatNo", equalTo("A2"));

		when().get("/buy")
		.then()
		.statusCode(HttpStatus.OK.value())
		.body("judgement", equalTo(false))
		.body("seatNo", equalTo(null));

		List<TicketSoldHistory> history = historyRepo.findAll();
		assertThat(history.size(),equalTo(tickets.size()));
		assertThat(history.get(0).getSeatNo(), equalTo(ticket1.getSeatNo()));
		assertThat(history.get(1).getSeatNo(), equalTo(ticket2.getSeatNo()));

	}
}
