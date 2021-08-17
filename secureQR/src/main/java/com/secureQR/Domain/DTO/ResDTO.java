package com.secureQR.Domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request Data Transfer Object
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResDTO {

    /**
     * Add additional instance members below
     */
    // Information in a Request
    private String resURL;
    //private String user;

    // Instance Member for URL registered Timestamp and URL modified as well

    //private LocalDateTime regDate, modDate;
}

