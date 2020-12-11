package com.delalama.backingtracks.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.persistence.Id;

@Data
@NoArgsConstructor
public class Audio {

    @Id
    @Indexed(unique = true)
    private String id;
    private byte[] data;

    public Audio(byte[] data) {
        this.data = data;
    }

}
