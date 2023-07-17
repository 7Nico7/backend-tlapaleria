package com.tlapaleria.sanchez.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class ImageDaoImpl implements ImageDao{

    @Override
    public boolean saveImage(MultipartFile imagen, String rutaDestino) throws IOException {

        if (imagen == null || imagen.isEmpty())
            return false;

        Path rutaDirectorio = Path.of(rutaDestino);
        String nombreArchivo = imagen.getOriginalFilename();
        Path rutaCompleta = rutaDirectorio.resolve(nombreArchivo);

        Files.copy(imagen.getInputStream(), rutaCompleta, StandardCopyOption.REPLACE_EXISTING);

        return true;
    }
}
