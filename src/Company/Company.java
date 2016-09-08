package Company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class Company {
	private List<Employee> employees = new ArrayList<Employee>();
	
	public void addEmployee(Employee employee) {
		
		employees.add(employee);
		
	}
	
	public int countSoftwareEngineers() {
		
		AtomicInteger totalSoftEngineer = new AtomicInteger(0);
		
		employees.forEach(e  -> {
			
			if(e.isSoftwareEngineer()){
				
				totalSoftEngineer.set(totalSoftEngineer.get() + 1);
				
			}
			
		});
		
		return totalSoftEngineer.get(); 
		
	}
	
	public int count(Predicate<Employee> p) {
		
		AtomicInteger total = new AtomicInteger(0); 
		
		employees.forEach(e -> {
		
		if (p.test(e)) {
			
			total.set(total.get() + 1);
			
		}
		
		});
		
		return total.get(); 
		
	}

	public boolean any(Predicate<Employee> p) {
	
		AtomicBoolean isThere = new AtomicBoolean(false); 
		
		employees.forEach(e -> {
			
			if(p.test(e)){
				
				isThere.set(true);
				
			}
			
		});
		
		return isThere.get();
	}

	public boolean all(Predicate<Employee> p) {
		
		AtomicInteger employeeCount = new AtomicInteger(0); 
		
		employees.forEach(e -> {
			
			if(p.test(e)){
				
				employeeCount.set(employeeCount.get() + 1);
				
			}
			
		});
		
		if(employeeCount.get() == employees.size()){
			
			return true; 
			
		}
		
		return false; 
	}
}
