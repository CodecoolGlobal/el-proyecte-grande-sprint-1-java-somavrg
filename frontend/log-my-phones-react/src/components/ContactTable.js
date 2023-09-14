
const ContactTable = ({contacts}) => {
return (
    <div className="ContactTable">
<table>
    <thead>
        <tr>
            <th>Calling number</th>
            <th>Called number</th>
            <th>Status</th>
            <th>Duration</th>
            <th>Date</th>
        </tr>
    </thead>
    <tbody>
        {contacts.map((contact) => (
            <tr key={contact.callId}>
                <td>{contact.callingNumber}</td>
                <td>{contact.calledNumber}</td>
                <td>{contact.callStatus}</td>
                <td>{contact.duration}</td>
                <td>{contact.dateTime}</td>
            </tr>
        ))}
    </tbody>
</table>
    </div>
)
};

export default ContactTable;