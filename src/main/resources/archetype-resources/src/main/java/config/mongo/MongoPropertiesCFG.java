#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package ${package}.config.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 *	Mongo properties configuration.
 */
@Data
@Component
@EqualsAndHashCode(callSuper = false)  
public class MongoPropertiesCFG {
  
	@Value("${symbol_dollar}{data.mongodb.uri}")
	private String uri;
}
