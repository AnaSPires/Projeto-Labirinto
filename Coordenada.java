import java.lang.reflect.*;  //para conter os metodos do java
public class Coordenada implements Cloneable
{
	 private int X;
	 private int Y;

	public void setX (int X) throws Exception
		{
			if (X<0 || X>8)
				throw new Exception ("Valor invalido para a coordenada X");

			this.X = X;
		}

		public void setY (int Y) throws Exception
		{
			if (Y<0 || Y>4)
				throw new Exception ("Valor invalido para a coordenada Y");

			this.Y = Y;
	}

	public Coordenada (int X, int Y) throws Exception
		{
			this.setX   (X);
			this.setY (Y);
	}

	public int getX ()
		{
			return this.X;
		}

		public int getY ()
		{
			return this.Y;
		}

		public String toString ()
			{
				return this.X +""+
				       this.Y +"";
	}

	public boolean equals (Object obj)
		{
			if (this==obj)
					    return true;

					if (obj==null)
					    return false;

					if (this.getClass()!=obj.getClass())
					    return false;

					Coordenada cor = (Coordenada)obj;

					    if (this.X != cor.X)
					        return false;

					  if (this.Y !=cor.Y))
					        return false;

						return true;
			}


		public int hashCode ()
			{
				int ret=666; // so nao pode ser zero

				ret = ret*2 + new Integer(this.X).hashCode();

				ret = ret*2 + new Integer(this.Y).hashCode();

				return ret;
			}



	//construtor de copia
		public Coordenada (Coordenada modelo) throws Exception
		{
			if (modelo==null)
				throw new Exception ("Modelo ausente");

			this.X = modelo.X;
			this.Y = modelo.Y;
		}

			public Object clone ()
			{
				Coordenada ret=null; //existe isso?

				try
				{
		    		ret = new Coordenada (this);
				}
				catch (Exception erro)
				{}

				return ret;
		}

				public int compareTo (Coordenada outro) // versao Hercules
			{
				int XDoThis, YDoOutro;

				segsDoThis  = this.segundos     +
							  this.minutos  *60 +
							  this.horas    *3600;

				segsDoOutro = outro.segundos     +
							  outro.minutos  *60 +
							  outro.horas    *3600;

				retun segsDoThis-segsDoOutro;
			}

}

