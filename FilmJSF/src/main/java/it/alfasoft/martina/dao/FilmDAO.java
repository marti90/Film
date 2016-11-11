package it.alfasoft.martina.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.alfasoft.martina.Film;
import it.alfasoft.martina.utility.HibernateUtility;

public class FilmDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		//1- CREATE
		public boolean createFilm(Film f){
				
			boolean res = false;
				
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
				
			try{
				tx = session.getTransaction();
				tx.begin();
					
				session.persist(f);
				
				tx.commit();
				res= true;
				
			}catch(Exception ex){
				tx.rollback();
					
			}finally{
				session.close();
					
			}
				
			return res;
		}
		
		//2.a- READ con titolo
		public Film readFilmConTitolo(String titolo){
				
			Film f = null;
				
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
				
			try{
				tx = session.getTransaction();
				tx.begin();
				
				Query query=session.createQuery("from Film where titolo=:titoloInserito");
				query.setString("titoloInserito",titolo);
		        f=(Film) query.uniqueResult();
					
				tx.commit();
					
			}catch(Exception ex){
				tx.rollback();
					
			}finally{
					session.close();
					
			}
			
			return f;
		}
			
		//2.b- READ con Codice
		public Film readFilmConCodice(String codiceFilm){
			
			Film f = null;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				f= session.get(Film.class, codiceFilm);
				
				tx.commit();
				
			}catch(Exception ex){
				tx.rollback();
				
			}finally{
				session.close();
				
			}
			
			return f;
		}
		
		//2.c- READ con id
				public Film readFilmConId(long id){
					
					Film f = null;
					
					Session session = HibernateUtility.openSession();
					Transaction tx = null;
					
					try{
						tx = session.getTransaction();
						tx.begin();
						
						f= session.get(Film.class, id);
						
						tx.commit();
						
					}catch(Exception ex){
						tx.rollback();
						
					}finally{
						session.close();
						
					}
					
					return f;
				}
		
		//2.d READ tutti i film della tabella
		@SuppressWarnings("unchecked")
		public List<Film> readFilm(){
			
			List<Film> film = new ArrayList<Film>();
			Session session=HibernateUtility.openSession();
			Transaction tx=null;
			
			try{
		        tx=session.getTransaction();
		        tx.begin();
		        
		        Query query = session.createQuery("from Film");
		        film= query.list();
		        
		        tx.commit(); 
	            
		    }catch(Exception ex){
		         tx.rollback();

		    }finally{
		         session.close();
		    }
		    
			return film;
			
		}
		
		//3- UPDATE
		public boolean updateFilm(Film f){

			boolean res = false;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				session.update(f);
				
				tx.commit();
				res= true;
				
				
			}catch(Exception ex){
				tx.rollback();
				
			}finally{
				session.close();
				
			}
			
			return res;
			
		}
		
		//4- DELETE
		public boolean deleteFilm(Film f){
	        
			boolean res = false;
			
			Session session = HibernateUtility.openSession();
			Transaction tx = null;
			
			try{
				tx = session.getTransaction();
				tx.begin();
				
				session.delete(f);
				
				tx.commit();
				res= true;
				
			}catch(Exception ex){
				tx.rollback();
				
			}finally{
				session.close();
				
			}
			
			return res;
			
		}

}
