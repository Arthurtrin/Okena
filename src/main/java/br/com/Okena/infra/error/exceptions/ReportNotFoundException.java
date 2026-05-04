package br.com.Okena.infra.error.exceptions;

public class ReportNotFoundException extends ResourceNotFoundException {

    public ReportNotFoundException(Long id){
        super("Report de id: " + id + " não encontrado.");
    }
}
