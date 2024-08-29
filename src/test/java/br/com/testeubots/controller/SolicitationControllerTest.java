//package br.com.testeubots.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//
//import br.com.testeubots.model.Solicitation;
//
//public class SolicitationControllerTest {
//
//	@Autowired
//	protected MockMvc mockMvc;
//
//	@Test
//	void sendSolicitation() throws Exception {
//
//		final Solicitation solicitation = new Solicitation("cards");
//
//		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		String json = ow.writeValueAsString(solicitation);
//
//		mockMvc.perform(post("/sendSolicitation").content(json).contentType(MediaType.APPLICATION_JSON)).andDo(print())
//				.andExpect(status().is2xxSuccessful());
//	}
//
//}
