package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class ProgramExceptions {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
		try {
			//Leitura dos dados da reserva
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());
			
			//Exibindo os dados da reserva com poss�veis erros tratados
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			//Leitura dos dados da altera��o da reserva
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			//Exibindo os dados da altera��o da reserva com poss�veis erros tratados
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		//catch gen�rico para n�o gerar exce��o com erro de execu��o
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
				
		sc.close();

	}

}
