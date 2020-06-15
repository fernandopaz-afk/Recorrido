
public class Arbol {
private Nodo raiz;
private String recorrido;

public Arbol(){
raiz=null;
recorrido= " ";
}
//metodo a envolver
private void insertarDesde(Nodo noda,Nodo Desde ){

if(Desde.obtenerData()==noda.obtenerData()){
return;
}
if(noda.obtenerData()>Desde.obtenerData()){
//colocar a la derecha 
if(Desde.der == null){
Desde.der=noda;
return;
}else{
insertarDesde(noda,Desde.der);
return;
}
}else{
//colocar a la izquierda
if(Desde.izq == null){
Desde.izq=noda;
return;
}else{
insertarDesde(noda,Desde.izq);
return;
}
}
}

//metodo que envuelve wrapper
public void insertar(Nodo noda){
if(raiz==null){
raiz=noda;
return;//termina el metodo
}
////////////
//si llego aqui la raiz no es nula 
insertarDesde(noda,raiz);
}

public boolean buscar(Nodo noba){
return buscarDesde(noba,raiz);
}
private boolean buscarDesde(Nodo noba, Nodo Desde){
if(Desde==null){
return false;
}

//cuando el nodo es el encontrado
if(Desde.obtenerData()==noba.obtenerData()){
return true;
}
if(noba.obtenerData()>Desde.obtenerData()){
//derecha
return buscarDesde(noba,Desde.der);
}else{
//izquierda
return buscarDesde(noba,Desde.izq);
}
}

public String toStringPreOrder(){
recorrido= " ";
/////////////////////////////

preOrderDesde(raiz);

////////////////////////////////
return recorrido;
}
//VID valor izquierdo derecho
private void preOrderDesde(Nodo desde){
if(desde==null){
return;
}
//valor
recorrido =recorrido +" "+desde;
//izq
preOrderDesde(desde.izq);
//der
preOrderDesde(desde.der);
}
public String toStringInOrder(){
recorrido= " ";
preInOrderDesde(raiz);
return recorrido;
}
//IVD izquierdo valor derecho
private void preInOrderDesde(Nodo desde){
if(desde==null){
return;
}

//izq
preInOrderDesde(desde.izq);

//valor
recorrido =recorrido +" "+desde;

//der
preInOrderDesde(desde.der);

}
//IDV izquierdo derecho valor
public String toStringPostOrder(){
recorrido= " ";
prePostOrderDesde(raiz);
return recorrido;
}

private void prePostOrderDesde(Nodo desde){
if(desde==null){
return;
}

//izq
prePostOrderDesde(desde.izq);
//der
prePostOrderDesde(desde.der);
//valor
recorrido =recorrido +" "+desde;

}
}
