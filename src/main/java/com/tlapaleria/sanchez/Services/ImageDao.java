package com.tlapaleria.sanchez.Services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageDao {

    boolean saveImage(MultipartFile imagen, String rutaDestino) throws Exception;
}
