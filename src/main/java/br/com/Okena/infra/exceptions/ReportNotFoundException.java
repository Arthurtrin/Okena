package br.com.Okena.infra.exceptions;

public class ReportNotFoundException extends RuntimeException {
    public ReportNotFoundException(String message) {
        super(message);
    }

    public ReportNotFoundException(Long id){
        super("Report de id: " + id + " não encontrado.");
    }
}
