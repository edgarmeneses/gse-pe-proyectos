package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class LinksDto {
    private final String self;
    private final String first;
    private final String last;
    private final String next;
    private final String prev;

    public LinksDto(String self, String first, String last, String next, String prev) {
        this.self = self;
        this.first = first;
        this.last = last;
        this.next = next;
        this.prev = prev;
    }

    public String self() { return self; }
    public String first() { return first; }
    public String last() { return last; }
    public String next() { return next; }
    public String prev() { return prev; }
}
