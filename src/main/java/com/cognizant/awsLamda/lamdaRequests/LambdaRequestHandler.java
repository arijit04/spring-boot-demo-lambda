/**
 * 
 */
package com.cognizant.awsLamda.lamdaRequests;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * @author 805796
 *
 */
public class LambdaRequestHandler implements RequestHandler<String, ResponseEntity<String>> {

	@Override
	public ResponseEntity<String> handleRequest(String input, Context context) {
		context.getLogger().log("This is my input string " + input);
		if(input.trim().isBlank()) {
			return new ResponseEntity<>("Please enter your name.", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Hello " + input.trim(), HttpStatus.OK);
	}

}
