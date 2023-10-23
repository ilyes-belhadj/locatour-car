/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

/**
 *
 * @author ahmed
 * @param <T>
 * @param <ID>
 */
public interface IService <T, ID>{
    public void ajoutervehicule(T p) ;
    public void supprimervehicule(ID id);
    public void modifiervehicule(T p);
    public List<T> affichervehicule();
}
