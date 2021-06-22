package fileSystem.components;

import fileSystem.models.File;
import fileSystem.models.Folder;
import fileSystem.models.User;
import fileSystem.repositories.FileRepository;
import fileSystem.repositories.FolderRepository;
import fileSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private FileRepository fileRepository;


    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        User lina = new User("Lina");
        userRepository.save(lina);
        User rob = new User("Rob");
        userRepository.save(rob);
        User bill = new User("Bill");
        userRepository.save(bill);
        User reaper = new User("Reaper");
        userRepository.save(reaper);


        Folder folder1 = new Folder("Classes", lina);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("Homework", rob);
        folderRepository.save(folder2);
        Folder folder3 = new Folder("E48", bill);
        folderRepository.save(folder3);
        Folder folder4 = new Folder("Codeclan", reaper);
        folderRepository.save(folder4);

        File file1 = new File("Notes", ".txt", 2, folder1);
        fileRepository.save(file1);
        File file2 = new File("Objects", ".java", 3, folder2);
        fileRepository.save(file2);
        File file3 = new File("Json", ".json", 4, folder3);
        fileRepository.save(file3);
        File file4 = new File("Python", ".py", 5, folder4);
        fileRepository.save(file4);
    }
}
