
package com.cts.config;

import com.cts.entity.Admin;
import com.cts.entity.SparePart;
import com.cts.repository.AdminRepository;
import com.cts.repository.SparePartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initAdmins(AdminRepository adminRepo) {
        return args -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (adminRepo.count() == 0) {
                Admin admin1 = new Admin();
                admin1.setUserId("ADMIN001");
                admin1.setName("Ullu Uzaafar");
                admin1.setEmail("uzaafar@gmail.com");
                admin1.setPasswordHash(encoder.encode("Uzaafar@2026"));
                adminRepo.save(admin1);

                Admin admin2 = new Admin();
                admin2.setUserId("ADMIN002");
                admin2.setName("Stylish Shadab");
                admin2.setEmail("shadab@gmail.com");
                admin2.setPasswordHash(encoder.encode("Shadab@2026"));
                adminRepo.save(admin2);

                Admin admin3 = new Admin();
                admin3.setUserId("ADMIN003");
                admin3.setName("Mass Manikantha");
                admin3.setEmail("manikantha@gmail.com");
                admin3.setPasswordHash(encoder.encode("Manikantha@2026"));
                adminRepo.save(admin3);

                Admin admin4 = new Admin();
                admin4.setUserId("ADMIN004");
                admin4.setName("Pattarbaaz Prateek");
                admin4.setEmail("prateek@gmail.com");
                admin4.setPasswordHash(encoder.encode("Prateek@2026"));
                adminRepo.save(admin4);

                Admin admin5 = new Admin();
                admin5.setUserId("ADMIN005");
                admin5.setName("Renuka");
                admin5.setEmail("renuka@gmail.com");
                admin5.setPasswordHash(encoder.encode("Renuka@2026"));
                adminRepo.save(admin5);

                System.out.println("✓ 5 Admin users created successfully!");
            }
        };
    }

    @Bean
    CommandLineRunner initSpareParts(SparePartRepository sparePartRepo) {
        return args -> {
            System.out.println("Checking spare parts table...");
            long count = sparePartRepo.count();
            System.out.println("Current spare parts count: " + count);
            
            if (count == 0) {
                System.out.println("Initializing spare parts data...");
                SparePart[] spareParts = {
                    new SparePart("Brake Pads", "Brakes", 45, 20, "AutoParts Inc.", 89.99, "High-performance ceramic brake pads for enhanced stopping power"),
                    new SparePart("Engine Oil Filter", "Engine", 12, 25, "OilTech Ltd.", 24.50, "Premium oil filter for optimal engine protection and performance"),
                    new SparePart("Air Filter", "Engine", 78, 15, "FilterCorp", 18.75, "High-flow air filter for improved engine breathing and efficiency"),
                    new SparePart("Spark Plugs", "Electrical", 5, 30, "SparkTech", 12.99, "Iridium spark plugs for reliable ignition and fuel efficiency"),
                    new SparePart("Tire Pressure Sensor", "Tires", 23, 10, "TireSense", 45.00, "TPMS sensor for accurate tire pressure monitoring and safety"),
                    new SparePart("Battery 12V", "Electrical", 8, 20, "PowerCell", 125.00, "Heavy-duty 12V automotive battery with 3-year warranty"),
                    new SparePart("Transmission Fluid", "Transmission", 34, 15, "TransOil Co.", 32.50, "Synthetic transmission fluid for smooth gear shifting"),
                    new SparePart("Radiator Hose", "Cooling", 2, 25, "CoolSys", 67.25, "Reinforced silicone radiator hose for high-temperature applications"),
                    new SparePart("Headlight Bulb H7", "Electrical", 156, 30, "BrightLite", 19.95, "LED headlight bulb with 6000K white light output"),
                    new SparePart("Windshield Wipers", "Accessories", 89, 25, "ClearView", 28.75, "All-weather windshield wipers with aerodynamic design"),
                    new SparePart("Cabin Air Filter", "HVAC", 67, 20, "FreshAir Pro", 22.50, "HEPA cabin air filter for clean interior air quality"),
                    new SparePart("Brake Fluid DOT 4", "Brakes", 41, 15, "StopSafe", 16.99, "High-performance DOT 4 brake fluid for all brake systems")
                };

                for (SparePart sparePart : spareParts) {
                    SparePart saved = sparePartRepo.save(sparePart);
                    System.out.println("Saved spare part: " + saved.getName() + " with ID: " + saved.getId());
                }

                System.out.println("✓ " + spareParts.length + " spare parts initialized successfully!");
            } else {
                System.out.println("Spare parts already exist in database.");
            }
        };
    }
}
