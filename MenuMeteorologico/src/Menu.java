import java.util.Scanner; //leitura de dados


public class Menu {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int op�ao, contadorData=0, dias;
		float media;
		Armazena[] dataTemperatura = new Armazena[120];
		
		for(int i=0; i<=120; i++) {
			dataTemperatura[i] = new Armazena(); 
		}
		
		dataTemperatura[0].ano = 2020;
		dataTemperatura[0].mes = 1;
		
		do {
			System.out.println("Digite 1 para fazer a entrada de temperaturas de um m�s.\nDigite 2 para calcular a m�dia de temperatura de um m�s.\nDigite 3 para ver a temperatura m�nima de um m�s.\nDigite 4 para ver a temperatura m�xima de um m�s.\nDigite 5 para ver o relat�rio meteorol�gico de um m�s.");
			op�ao = ler.nextInt();
			
			dias = Entradas(contadorData, dataTemperatura);
			
			switch(op�ao) {
				case 1: 
					Entradas(contadorData, dataTemperatura);
					contadorData++;
					break;
				case 2:
					Entradas(contadorData, dataTemperatura);
					media = CalculoTemperaturaMedia(dias, dataTemperatura, contadorData);
					System.out.println("A media de temperatura do m�s � igual a " + media);
					break;
				case 3:
					CalculoTemperaturaMinima(dias, dataTemperatura, contadorData);
					break;
				case 4:
					CalculoTemperaturaMaxima(dias, dataTemperatura, contadorData);
					break;
				case 5:
					System.out.println("Relat�rio do m�s " + dataTemperatura[contadorData].mes + " de " + dataTemperatura[contadorData].ano);
					Entradas(contadorData, dataTemperatura);
					media = CalculoTemperaturaMedia(dias, dataTemperatura, contadorData);
					System.out.println("A media de temperatura do m�s � igual a " + media);
					CalculoTemperaturaMinima(dias, dataTemperatura, contadorData);
					CalculoTemperaturaMaxima(dias, dataTemperatura, contadorData);
					break;
				case 6:
					System.out.println("At� logo!");
					break;
				default:
					System.out.println("Op��o inv�lida! Escolha entre os n�meros de 1 a 5.");

					break;
			}
		}while(op�ao!=6);
	}

	public static float CalculoTemperaturaMedia(int qDias, Armazena[] dataTemperatura, int contadorData) {

		float soma=0, mediaTemperaturasMes;
		int i;
		
		for(i=0; i<qDias; i++) {
			soma+=dataTemperatura[contadorData].temperaturas[i];
		}
		
		mediaTemperaturasMes = soma/qDias;
		
		return mediaTemperaturasMes;
	}
	
	public static void CalculoTemperaturaMinima(int qDias, Armazena[] dataTemperatura, int contadorData) {
		float menor=0;
		int i, diaOcorrido;
		
		for (i=1; i<=qDias; i++) {
			if(i==1) {
				menor = dataTemperatura[contadorData].temperaturas[i];
			}else {
				if(dataTemperatura[contadorData].temperaturas[i]<menor) {
					menor = dataTemperatura[contadorData].temperaturas[i];
				}
			}
		}
		
		System.out.println("A menor temperatura foi " + dataTemperatura[contadorData].temperaturas[i] );
		
		for(i=1; i<=qDias; i++) {
			if(dataTemperatura[contadorData].temperaturas[i]==menor) {
				diaOcorrido = qDias;
				System.out.println("Ela ocorreu nos dia(s): " + diaOcorrido);
			}
		}
		
		
	}
	
	public static void CalculoTemperaturaMaxima(int qDias, Armazena[] dataTemperatura, int contadorData) {
		float maior=0;
		int i, diaOcorrido;
		
		for (i=1; i<=qDias; i++) {
			if(i==1) {
				maior = dataTemperatura[contadorData].temperaturas[i];
			}else {
				if(dataTemperatura[contadorData].temperaturas[i]>maior) {
					maior = dataTemperatura[contadorData].temperaturas[i];
				}
			}
		}
		
		System.out.println("A maior temperatura foi " + dataTemperatura[contadorData].temperaturas[i] );
			
			for(i=1; i<=qDias; i++) {
				if(dataTemperatura[contadorData].temperaturas[i]==maior) {
					diaOcorrido = qDias;
					System.out.println("Ela ocorreu nos dia(s): " + diaOcorrido);
				}
			}
		}
		
	public static int Entradas(int contadorData, Armazena[] dataTemperatura) {
		int resto4, resto100, resto400, quantidadeDias=0, i;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o mes:");
		dataTemperatura[contadorData].mes = ler.nextInt();
		if(dataTemperatura[contadorData].mes<1 || dataTemperatura[contadorData].mes>12) {
			do {
				System.out.println("M�s inv�lido! Digite um m�s v�lido (1 a 12)");
				dataTemperatura[contadorData].mes = ler.nextInt();
				
			}while(dataTemperatura[contadorData].mes<1||dataTemperatura[contadorData].mes>12);
		}
		System.out.println("Digite o ano:");
		dataTemperatura[contadorData].ano = ler.nextInt();
		if(dataTemperatura[contadorData].ano<2011||dataTemperatura[contadorData].ano>2020) {
			do {
				System.out.println("Ano inv�lido! Digite um ano v�lido (2011 a 2020)");
				dataTemperatura[contadorData].ano = ler.nextInt();
			}while(dataTemperatura[contadorData].ano<2011||dataTemperatura[contadorData].ano>2020);
		}
		if(dataTemperatura[contadorData].mes >= 1 && dataTemperatura[contadorData].mes <= 12) {
			if(dataTemperatura[contadorData].mes == 1 || dataTemperatura[contadorData].mes == 3 || dataTemperatura[contadorData].mes == 5 || dataTemperatura[contadorData].mes == 7 || dataTemperatura[contadorData].mes == 8 || dataTemperatura[contadorData].mes == 10|| dataTemperatura[contadorData].mes == 12) {
				quantidadeDias = 31;
			} else if (dataTemperatura[contadorData].mes == 4 || dataTemperatura[contadorData].mes == 6 || dataTemperatura[contadorData].mes == 9 || dataTemperatura[contadorData].mes == 11) {
				quantidadeDias = 30;
			} else if (dataTemperatura[contadorData].mes == 2) {
				resto4 = dataTemperatura[contadorData].ano % 4;
				resto100 = dataTemperatura[contadorData].ano % 100;
				resto400 = dataTemperatura[contadorData].ano % 400;
				if (resto4 == 0 && resto100 != 0 || resto400 == 0){
					quantidadeDias=29;
				} else {
					quantidadeDias=28;
				}

			}
		}
		
		for (i = 0; i<quantidadeDias; i++) {
			System.out.println("Insira a m�dia de temperatura do dia" + (i+1));
			dataTemperatura[contadorData].temperaturas[i]= ler.nextFloat();
		}
		
		return quantidadeDias;
	}

}


