
const ContactTable = ({contacts}) => {
return (
    <div className="ContactTable">
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Phone number</th>
         </tr>
    </thead>
    <tbody>
        {contacts.map((contact) => (
            <tr key={contact.contactId}>
                <td>{contact.name}</td>
                <td>{contact.phoneNumber}</td>
             </tr>
        ))}
    </tbody>
</table>
    </div>
)
};

export default ContactTable;