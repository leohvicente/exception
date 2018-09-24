package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class ReservaHotel {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Número do quarto");
		int number = sc.nextInt();
		System.out.println("Data checkin: ");
		Date chekIn = sdf.parse(sc.next());
		System.out.println("Data checkout: ");
		Date chekOut = sdf.parse(sc.next());
		
		if (!chekOut.after(chekIn)) {
			System.out.println("Erro: Data checout deve ser maior que checkin");
			
		}else {
			Reservation reservation = new Reservation(number, chekIn, chekOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println("");
			System.out.println("Informe data para atualizar: ");
			chekIn = sdf.parse(sc.next());
			System.out.println("Data checkout: ");
			chekOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			if (chekIn.before(now)  || chekOut.before(now) ) {
				System.out.println("Erro: Data checout deve ser maior que checkin");
		}else if (!chekOut.after(chekIn)) {
			System.out.println("Erro: Data checout deve ser maior que checkin");
		}else {
				
			reservation.updateDates(chekIn, chekOut);			
			System.out.println("Reserva: " + reservation);
			
		}
			
		}
		
		
		
		sc.close();
		
		
		
		

	}

}
