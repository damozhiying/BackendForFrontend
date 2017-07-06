package br.com.cdsoft.rest;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.cdsoft.oauth.UserInfoTokenUtil;

@RestController
public class BFFRestResource {
	@Value("${service.properties.url}")
	private String urlProperties;
	private static final String BEARER = "Bearer ";
	private static final String AUTHORIZATION = "Authorization";
	@Autowired
	UserInfoTokenUtil userInfoTokenUtil;
	@Secured("ROLE_ADMIN")
	@RequestMapping(produces = MediaType.APPLICATION_JSON, path = "/bff/properties", method = RequestMethod.GET)
	public ResponseEntity<String> getProperties() {
		RestTemplate restTemplate = new RestTemplate();

		final HttpHeaders headers = new HttpHeaders();
		headers.add(AUTHORIZATION, BEARER.concat(userInfoTokenUtil.getToken()));
		final HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(urlProperties, HttpMethod.GET, entity, String.class);
	}

}
