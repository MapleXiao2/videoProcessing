package com.maple.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInformation implements Serializable {
    private String[] videos;
    private String images;
}
