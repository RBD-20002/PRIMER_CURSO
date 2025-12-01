package SQL;

import java.time.LocalDateTime;

public class Movimiento {

    private final int id;
    private int idOrigen;
    private int idDestino;
    private double monto;
    private LocalDateTime fecha;

    public Movimiento(int id, int idOrigen, int idDestino, double monto, LocalDateTime fecha) {
        this.id = id;
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.monto = monto;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ID: "+id+" | ID ORIGEN: "+idOrigen+" | ID DESTINO: "+idDestino+" | MONTO: "+monto+" | FECHA: "+fecha;
    }
}
