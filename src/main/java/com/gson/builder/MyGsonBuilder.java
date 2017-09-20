package com.gson.builder;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.gson.vo.Person;
import com.gson.vo.Student;
import com.gson.vo.Teacher;

public class MyGsonBuilder {

	public static GsonBuilder getMyGsonBuilder(){
		GsonBuilder builder = new GsonBuilder().registerTypeAdapter(new TypeToken<Person>(){}.getType(), new JsonDeserializer<Person>() {

			public Person deserialize(JsonElement json, Type type, JsonDeserializationContext context)
					throws JsonParseException {
				String occupation = json.getAsJsonObject().get("occupation").getAsString();
				Person person = context.deserialize(json, PersonType.getByOccupation(occupation).getClassType());
				return person;
			}
			
		});
		return builder;
	}
	
	enum PersonType {
		WITHSTUDENT("student",Student.class,"student"),
		WITHTEACHER("teacher",Teacher.class,"teacher");
		
		private String displayName;  
	    private Class<? extends Person> classType;  
	    private String occupation;  
	  
	    public String getDisplayName() {  
	        return displayName;  
	    }  
	  
	    public void setDisplayName(String displayName) {  
	        this.displayName = displayName;  
	    }  
	  
	  
	    private PersonType(String displayName, Class<? extends Person> classType , String occupation) {  
	        this.displayName = displayName;  
	        this.classType = classType;  
	        this.occupation = occupation;  
	    }  
	    public static PersonType getByOccupation(String occupation){  
	        for(PersonType t : values()){  
	            if(t.getOccupation().equals(occupation)){  
	                return t;  
	            }  
	        }  
	        return null;  
	    }

		public Class<? extends Person> getClassType() {
			return classType;
		}

		public void setClassType(Class<? extends Person> classType) {
			this.classType = classType;
		}

		public String getOccupation() {
			return occupation;
		}

		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
	}
}
