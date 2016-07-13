package de.sha.ticketpie.repository;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import de.sha.ticketpie.TicketPieApplication;
import de.sha.ticketpie.entity.Ticket;


@SpringApplicationConfiguration(classes = TicketPieApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)

public class TicketRepositoryTest {

	@Autowired
	private TicketRepository repo;

	@Test
	public void test() throws Exception{

		Ticket t = new Ticket("A1",false);
		repo.save(t);

		List<Ticket> list = repo.findAll();
		System.out.println(list.get(0).updateDateTime.getTime());
		assertThat(list.size(), equalTo(1));



	}
}
