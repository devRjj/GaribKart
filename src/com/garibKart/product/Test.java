package com.garibKart.product;


public class Test {

	public static void main(String[] args) {
		Insertdata data = new Insertdata();
				data.insertProd(101, "mobile", "OnePlus 12(Silky Black, 16 GB RAM, 512GB Storage)", 50000, 50);
				data.insertProd(102, "Laptop", "HP Laptop 15s, AMD Ryzen 3 5300U, 15.6-inch (39.6 cm), FHD, 8GB DDR4, 512GB SSD, AMD Radeon Graphics, Thin & Light, Dual Speakers (Win 11, MSO 2019, Silver, 1.69 kg), eq2143AU", 60000, 100);
				data.insertProd(103, "TV", "HP Laptop 15s, AMD Ryzen 3 5300U, 15.6-inch (39.6 cm), FHD, 8GB DDR4, 512GB SSD, AMD Radeon Graphics, Thin & Light, Dual Speakers (Win 11, MSO 2019, Silver, 1.69 kg), eq2143AU", 35000, 100);
				data.insertProd(104, "office chair", "PRENIX High Back Revolving Home and Office Desk Chair|Height Adjustment, Rolling Swivel, Lumbar Support, and Comfortable Armrest (Black)", 9999, 100);
				data.insertProd(105, "watch", "Apple Watch Ultra 2 [GPS + Cellular 49mm] Smartwatch with Rugged Titanium Case & Orange Ocean Band One Size. Fitness Tracker,Precision GPS,Action Button,Extra-Long Battery Life,Bright Retina Display", 84000, 100);
				data.insertProd(106, "Guitar","Yamaha F280 Acoustic Rosewood Guitar (Natural, Beige)", 8000, 100);
				data.insertProd(107, "trolley Bag", "Safari Pentagon 65 Cms Medium Check-in Polypropylene (Pp) Hardshell Sided 4 Wheels 360 Degree Rotation Luggage/Suitcase/Inline Trolley Bag (Cyan Blue)", 1800, 100);
				data.insertProd(108, "Treadmills", "Lifelong FitPro (2.5 HP Peak) Manual Incline Motorized Treadmill for Home with 12 preset Workouts, Max Speed 12km/hr. Bluetooth Speaker|Max. User Weight 100Kg, (LLTM09)", 18000, 100);
				data.insertProd(109, "Dining Table", "SONA ART & CRAFTS Solid Sheesham Wood Dining Table 4 Seater Dining Table Set with 2 Chairs & 1 Bench Dinner Table Set for Dinning Room Home,Hotel and Office", 15000, 100);
				data.insertProd(110, "Electric bike", "Okaya Faast F2B Electric Scooter (Advance Booking for Ex-Showroom) | 80-85 km Range Per Charge | Metallic White (Portable Charger)", 100000, 100);

		data.showProducts();
	}

}
