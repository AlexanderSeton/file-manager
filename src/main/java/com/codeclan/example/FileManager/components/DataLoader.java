package com.codeclan.example.FileManager.components;

import com.codeclan.example.FileManager.models.File;
import com.codeclan.example.FileManager.models.Folder;
import com.codeclan.example.FileManager.models.User;
import com.codeclan.example.FileManager.repositories.FileRepository;
import com.codeclan.example.FileManager.repositories.FolderRepository;
import com.codeclan.example.FileManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    UserRepository userRepository;

    public void run(ApplicationArguments args) {

        User user1 = new User("John");
        Folder downloads = new Folder("downloads", user1);
        File dogVideo = new File("Dog Video (YouTube)", "mp4", 358, downloads);
        File catVideo = new File("Cat Video (YouTube)", "mp4", 258, downloads);
        List<File> files1 = new ArrayList<>(Arrays.asList(dogVideo, catVideo));
        downloads.setFiles(files1);
        Folder desktop = new Folder("desktop", user1);
        File intellij = new File("Intellij IDEA CE", "app", 1200, desktop);
        List<File> files2 = new ArrayList<>(Arrays.asList(intellij));
        desktop.setFiles(files2);
        List<Folder> folders1 = new ArrayList<>(Arrays.asList(downloads, desktop));
        user1.setFolders(folders1);

        User user2 = new User("Tim");
        Folder work = new Folder("work", user2);
        File appStore = new File("App Store", "app", 2455, work);
        List<File> files3 = new ArrayList<>(Arrays.asList(appStore));
        work.setFiles(files3);
        List<Folder> folders2 = new ArrayList<>(Arrays.asList(work));
        user2.setFolders(folders2);

        userRepository.save(user1);
        userRepository.save(user2);
        folderRepository.save(downloads);
        folderRepository.save(desktop);
        folderRepository.save(work);
        fileRepository.save(dogVideo);
        fileRepository.save(catVideo);
        fileRepository.save(intellij);
        fileRepository.save(appStore);

    }

}
