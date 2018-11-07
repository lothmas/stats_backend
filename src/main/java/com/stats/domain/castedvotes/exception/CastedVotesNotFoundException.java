/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.stats.domain.castedvotes.exception;

/**
 *
 * @author kwk
 */
public class CastedVotesNotFoundException extends Exception{


//    private final Logger log = Logger.getLogger(VotesEntityNotFoundException.class);

    /**
     *
     * @param message
     */
    public CastedVotesNotFoundException(String message)
    {
        super(message);
//        log.debug(message); // Send the error message to the logger..
    }
}
