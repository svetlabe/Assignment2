import React from "react";
import { useParams } from "react-router-dom";
import { RestClient } from "../RestClient"

export default function AddConfigurationToEnvironment() {
    let {id}: any = useParams();
    let [environment, setEnvironment] = React.useState<any>(undefined)

    React.useEffect(() => {
        RestClient.getEnvironment(id)
            .then(environment => setEnvironment(environment))
            .catch((err: any) => alert(err))
    }, [])
    if (environment) {
        return (
            <React.Fragment>
                <AdddConfiguration {...environment} />
            </React.Fragment>
        )
    } else {
        return <p>...</p>
    }
}

function AdddConfiguration(environment: any) {

    const [value, setValue] = React.useState(0)

    const handleSubmit = (e: any) => {
        e.preventDefault();
        let config = {
            name: (document.getElementById('name') as HTMLInputElement).value,
            version: (document.getElementById('version') as HTMLInputElement).value,
            date: (document.getElementById('date') as HTMLInputElement).value
        }
        RestClient.addConfigurationForEnv(environment.id, config)
            .then( () => {
                e.target.reset()
                environment.configurationData.push(config)
                setValue(value => value + 1)
            })
            .catch( (e: any) => alert(e))
    }

    return (
        <div>
            <h2>Add configuration details</h2>
            <form onSubmit={handleSubmit}>
                <p>
                    <label htmlFor='name'>Name</label>
                    <input type='text' id='name'/>
                </p>
                <p>
                    <label htmlFor='version'>Version</label>
                    <input type='text' id='version'/>
                </p>
                <p>
                    <label htmlFor='date'>Date changed</label>
                    <input id='date' type='text' min={1}/>

                </p>
                <p>
                    <label>&nbsp;</label> {/* Placeholder */}
                    <button>Add environment</button>
                </p>
            </form>
        </div>
    )}