package icesi.edu.co.stm.delegate;

import java.io.Serializable;

public class TransactionBody<T,K> implements Serializable{
	private static final long serialVersionUID = 1L;
    private String apiContext;
    private T body;
    private K id;
    
    public TransactionBody() {
    }

    public TransactionBody(String apiContext, T body) {
        this.apiContext = apiContext;
        this.body = body;
    }
    
    
    public TransactionBody(String apiContext, T body,K id) {
        this.apiContext = apiContext;
        this.body = body;
        this.id = id;
    }

    public String getApiContext() {
        return apiContext;
    }

    public void setApiContext(String apiContext) {
        this.apiContext = apiContext;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
    
    public K getId() {
    	return id;
    }
    
    public void setId(K id) {
    	this.id=id;
    }
}
