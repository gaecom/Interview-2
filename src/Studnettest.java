import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Studnettest {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student(3);

		s.setAge(10);
		s.setName("test");
		s.setGender("man");
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("object"));
			oos.writeObject(s);
			oos.flush();
			ois = new ObjectInputStream(new FileInputStream("object"));
			
			Student objectFromStream = (Student) ois.readObject();

			System.out.println(objectFromStream.getName() + " "
					+ objectFromStream.getAge() + " "
					+ objectFromStream.getGender());
		} catch (Exception e) {
			System.out.println("file error!");
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if(oos != null){
					oos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
