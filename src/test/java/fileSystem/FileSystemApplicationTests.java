package fileSystem;

import fileSystem.models.File;
import fileSystem.models.Folder;
import fileSystem.models.User;
import fileSystem.repositories.FileRepository;
import fileSystem.repositories.FolderRepository;
import fileSystem.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;

@RunWith(SpringRunner.class)
@SpringBootTest
class FileSystemApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FolderRepository folderRepository;

	@Autowired
	private FileRepository fileRepository;


	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateAndSaveUserANdFolder() {
		User lina = new User("Lina");
		userRepository.save(lina);

		Folder folder1 = new Folder("Classes", lina);
		folderRepository.save(folder1);
	}

	@Test
	public void canSaveFileToFolder() {
		User lina = new User("Lina");
		userRepository.save(lina);

		Folder folder1 = new Folder("Classes", lina);
		folderRepository.save(folder1);

		File file1 = new File("Notes", ".txt", 2, folder1);
        fileRepository.save(file1);

		folder1.addFile(file1);
		folderRepository.save(folder1);
	}



}
