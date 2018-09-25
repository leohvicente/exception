package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class ReservaHotel {

	public static void main(String[] args)  {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Número do quarto");
			int number = sc.nextInt();
			System.out.println("Data checkin: ");
			Date chekIn = sdf.parse(sc.next());
			System.out.println("Data checkout: ");
			Date chekOut = sdf.parse(sc.next());
	
			
			Reservation reservation = new Reservation(number, chekIn, chekOut);
			System.out.println("Reserva: " + reservation);
	
			System.out.println("");
			System.out.println("Informe data para atualizar: ");
			chekIn = sdf.parse(sc.next());
			System.out.println("Data checkout: ");
			chekOut = sdf.parse(sc.next());
	
			reservation.updateDates(chekIn, chekOut);
			System.out.println("Reserva: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Data Invalida");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro Inesperado");
		}

		sc.close();

	}

}
