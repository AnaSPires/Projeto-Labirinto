import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Labirinto
{
	 public static void main (String[] args)
	 {
		 try
		 		{
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
								// Le entao a palagra SAIR nao seja digitada
						Char character = "";
						int[][] matriz = new int[5][9];
						 while ((character = in.readLine())!=null)
						 {
							System.out.println("Voce digitou: "+ linha);

							for(int linhas=0;linhas<5;linhas++)
							{
								for(int cols=0;cols<9;cols++)
								{
								matriz[linhas][cols]=reader.readLine();;
								}
							}

						 }


					Pilha<Coordenada> caminho = new Pilha <Coordenada>(40);

            		Pilha<Fila<Coordenada>> possibilidades = new Pilha<Fila<Coordenada>>(40);
            		public void EncontrarEntrada()
					{

					}


		 	    }

		 	    catch (Exception erro)
		 	    {
		 			System.err.println (erro.getMessage());
				}

	 }
}