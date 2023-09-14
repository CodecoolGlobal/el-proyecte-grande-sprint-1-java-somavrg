import { useState, useEffect } from "react";

const fetchContacts = () => {
    return fetch("/api/contacts").then((res) => res.json());
  };

const Contacts = ()=>{
    const [contacts, setContacts] = useState([]);

    useEffect(()=> {
        fetchContacts.then((contacts)=> {
            setContacts(contacts)
        })
    },[])

return null;
    

}

export default Contacts;