package com.example.cesijeujura.IDAO;

public interface GenericIDAO<T> {

	/**
	 * Cr�er une valeur dans la table
	 * @param t
	 * @return
	 */
	public T create(T t);
	/**
	 * Mettre � jour la valeur dans la table 
	 * @param t
	 * @return
	 */
	public T update(T t);
	/**
	 * Trouver un champ dans la table
	 * @param id
	 * @return
	 */
	public T find(int id);
	/**
	 * Supprimer un champ dans la table
	 * @param id
	 * @return
	 */
	public void delete(int id);
}
