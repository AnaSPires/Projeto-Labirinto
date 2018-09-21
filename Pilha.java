/*
Convenções de Nomenclatura

1) Pacotes (biblioteca)
   Tem seus nomes escritos totalmente com
   letras minusculas e as palavras sao
   separadas por . (ponto)

2) Classes e Projetos
   Palavras justapostas com iniciais
   maiúsculas e as demais letras
   minúsculas

3) Atributos, variaveis locais, parametros e métodos
   Segue a regra 2 com a seguinte adaptacao:
   a primeira palavra que forma o nome será
   totalmente minuscula

4) Constantes (final float PI=3.14f;)
   Tem seus nomes escritos totalmente com
   letras maiusculas e as palavras sao
   separadas por _ (underline)

Obs: palavras reservadas pela linguagem e
     tipos escalares sao totalmente minusculos
*/

/*
TIPOS ESCALARES		CLASSES WRAPPER
byte			Byte
short			Short
int			Integer
long			Long

float			Float
double			Double

char			Character

boolean			Boolean

			Ex.:
			public class Programa
			{
			    public static void main (Horario[] args)
			    {
			        int a, b=7, c=13;

			        a = (b+c)/2;

				System.out.println ("A media de "+b+" e "+c+" vale "+a);
			    }
			}

			public class Programa
			{
			    public static void main (Horario[] args)
			    {
			        Integer a, b=new Integer (7), c=new Integer (13);

			        a = new Integer ((b.intValue()+c.intValue())/2);

				System.out.println ("A media de "+b.intValue()+" e "+c.intValue()+" vale "+a.intValue());
			    }
			}

			public class Programa
			{
			    public static void main (Horario[] args)
			    {
			        Integer a, b=7, c=13;

			        a = (b+c)/2;

				System.out.println ("A media de "+b+" e "+c+" vale "+a);
			    }
			}

			public class Programa
			{
			    public static void main (Horario[] args)
			    {
			        Horario a, b=new Horario("COTUCA"), c=new Horario("UNICAMP");

			        a = b.concat(new Horario("/").concat(c));

				System.out.println (a.toHorario());
			    }
			}

			public class Programa
			{
			    public static void main (Horario[] args)
			    {
			        Horario a, b="COTUCA", c="UNICAMP"; // proprio de wrapper, mas nao é wrapper

			        a = b+"/"+c; // proprio de wrapper, mas nao é wrapper

				System.out.println (a); // proprio de wrapper, mas nao é wrapper
			    }
			}

			public class Programa
			{
			    public static void main (Horario[] args)
			    {
			        int i=13;

			        Horario s=""+i; // truque para tranformar em Horario; estou aplicando a um int, mas poderia ser aplicado a qualquer coisa, objetos ou escalares

			        ...
			    }
			}

			public class Programa
			{
			    public static void main (Horario[] args)
			    {
			        Horario s="3.14";

				float piEscalar=Float.parseFloat(s); // nao tem truque; só mesmo usando um método
                                Float piObjeto =new Float (s);

			        ...
			    }
			}

*/

public class Pilha
{
    private Horario[] vetor;
    private int qtd = 0;

    //versao preventiva
    public Pilha (int capacidade) throws Exception
    {
        if (capacidade<0)
            throw new Exception ("Capacidade invalida");

        this.vetor = new Horario [capacidade];
    }

    //versao remediadora
    /*
    public Pilha (int capacidade) throws Exception
    {
        try
        {
            this.vetor = new Horario [capacidade];
        }
        catch (NegativeArraySizeException erro)
        {
            throw new Exception ("Capacidade invalida");
        }
    }
    */

    public void guarde (Horario s) throws Exception
    {
		if (s==null || s.equals(""))
				throw new Exception ("Informacao ausente");

		if (this.isCheia())
				throw new Exception ("Pilha cheia");

      //this.vetor[this.qtd] = (Horario)s.clone();
        this.vetor[this.qtd] = new Horario(s);
        this.qtd++;
    }

    public Horario getUmItem () throws Exception
    {
        if (this.isVazia())
            throw new Exception ("Nada a recuperar");

      //return new Horario(this.vetor[this.qtd-1]);
        return (Horario)this.vetor[this.qtd-1].clone();
    }

    public void jogueForaUmItem () throws Exception
    {
	if (this.isVazia())
	{    Exception problema;
	     problema = new Exception ("Pilha vazia");
	     throw problema;
	}

        this.qtd--;
        this.vetor[this.qtd]=null;
    }

    public boolean isCheia ()
    {
        return this.qtd==this.vetor.length;
    }

    public boolean isVazia ()
    {
        return this.qtd==0;
    }

    public String toString ()
    {
		if (this.qtd==0)
		    return "Vazia";

		return this.qtd+" elementos, sendo o ultimo "+this.vetor[this.qtd-1];
	}

	//compara this e obj
	public boolean equals (Object obj)
	{
		if (this==obj)
		    return true;

		if (obj==null)
		    return false;

		if (this.getClass()!=obj.getClass())
		    return false;

		Pilha pil = (Pilha)obj;

		if (this.qtd!=pil.qtd)
		    return false;

		for (int i=0; i<this.qtd; i++)
		    if (!this.vetor[i].equals(pil.vetor[i]))
		        return false;

		return true;
	}

	public int hashCode ()
	{
		int ret=666; // so nao pode ser zero

		ret = ret*2 + new Integer(this.qtd).hashCode();

        for (int i=0; i<this.qtd; i++)
          //if (this.vetor[i]!=null)
				ret = ret*2 + this.vetor[i].hashCode();

		return ret;
	}
}