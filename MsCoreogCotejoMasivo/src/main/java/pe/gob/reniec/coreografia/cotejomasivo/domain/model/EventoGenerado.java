package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

/**
 * Value Object - Representa un evento generado por el proceso de coreografía
 */
public class EventoGenerado {
    
    private String eventId;
    private String eventType;
    private String topic;
    
    public EventoGenerado() {
    }
    
    public EventoGenerado(String eventId, String eventType, String topic) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.topic = topic;
    }
    
    public String getEventId() {
        return eventId;
    }
    
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    
    public String getEventType() {
        return eventType;
    }
    
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    
    public String getTopic() {
        return topic;
    }
    
    public void setTopic(String topic) {
        this.topic = topic;
    }
}
