import React from "react";
import {RestClient} from "../RestClient";

export default function AddEnvironment2(){
    let [environments, setEnvironments] = React.useState<Array<any>>([])

    React.useEffect(() => {
            RestClient.getEnvironments()
                .then(environments => setEnvironments(environments))},
        [])
    return (
        <React.Fragment>
            {AddElement()}
            <div>
              Add new Environment

            </div>
        </React.Fragment>
    );

    function AddElement(){
        const handleSubmit = (e: any) => {
            e.preventDefault();
            let environmentToAdd = {
                shortName: (document.getElementById('shortName') as HTMLInputElement).value,
                longName: (document.getElementById('longName') as HTMLInputElement).value,
            }
            RestClient.addEnvironment(environmentToAdd)
                .then( () => {
                    e.target.reset()
                    environments.push(environmentToAdd)
                })
                .catch( (e: any) => alert(e))
        }

        return(
            <div>
                <h2>Add new Environment</h2>
                <form onSubmit={handleSubmit}>
                    <p>
                        <label htmlFor='shortName'>Short Name</label>
                        <input type='text' id='shortName'/>
                    </p>

                    <p>
                        <label htmlFor='longName'>Description</label>
                        <input type='text' id='longName'/>
                    </p>
                    <p>
                        <label>&nbsp;</label> {/* Placeholder */}
                        <button>Add environment</button>
                    </p>
                </form>
            </div>)

    }
}