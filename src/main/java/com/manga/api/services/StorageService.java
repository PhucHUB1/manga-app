package com.manga.api.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("src/main/resources/static/images");

	public void store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public void store(MultipartFile file, String folderName) {
		try {
			Path path = this.rootLocation.resolve(folderName);
			Files.createDirectories(path);
			Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}
	
	public void delete(String path)
	{
		try {
			File file = this.rootLocation.resolve(path).toFile();
			File[] contents = file.listFiles();
		    if (contents != null) {
		        for (File f : contents) {
		            f.delete();
		        }
		    }
		    file.delete();
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}
	
	public void copyDefaultAvatar(String fileName) {
		try {
			Path src = this.rootLocation.resolve("default.jpg");
			Path dest = this.rootLocation.resolve(fileName);
			Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
}