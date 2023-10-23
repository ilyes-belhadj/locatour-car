/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author ahmed
 */
interface ImarketplaceService<T0, T1> {
    public void ajouter(T0 p) ;
    public void modifier(T0 p);
    public void supprimer(T0 m);
}
