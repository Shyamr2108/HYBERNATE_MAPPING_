
import javax.persistence.EntityManager;

import com.masai.main.EMUtils.EMUtils;
import com.masai.main.entity.Address;
import com.masai.main.entity.Customer;

public class App {
		public static void main(String args[])
		{
			EntityManager em=EMUtils.provideEntityManager();
			
			Address d1 = new Address();
			d1.setState("WestBengal");
			d1.setCity("kharagpur");
			d1.setPincode(110001);


			Address d2 = new Address();
			d2.setState("haryana");
			d2.setCity("sonipat");
			d2.setPincode(234567);

			Customer c1 = new Customer();
			c1.setCname("shyam");
			c1.setMobile("99899500");
			c1.setEmail("shyam@gmail.com");
			
			
			Customer c2 = new Customer();
			c2.setCname("rohan");
			c2.setMobile("988830000");
			c2.setEmail("rohan@yahoo.com");
			
			c1.getAdds().add(d1);
			c2.getAdds().add(d1);
			
			
			d1.getCust().add(c1);
			d1.getCust().add(c2);
			
			em.getTransaction().begin();
			
			em.persist(d1);
			em.persist(d2);
			
			em.getTransaction().commit();

			System.out.println("done");
		}


}
