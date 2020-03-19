package br.com.transacao.util;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

    private T data;
    private List<T> datas;
    private List<String> errors;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
   

    public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public List<String> getErrors() {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "Response [data=" + data + ", errors=" + errors + "]";
    }

}