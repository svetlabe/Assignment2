import React from "react";
import { useParams } from "react-router-dom";
import { RestClient } from "../RestClient"

export default function Environment() {
	
	let { id } : any = useParams();
	let [environment, setEnviroment] = React.useState<any>(undefined)

	React.useEffect(() => {
		RestClient.getEnvironment(id)
		          .then(environment => setEnviroment(environment))
				  .catch((err: any) => alert(err))
	}, [])

	if (environment) {
		return (
			<React.Fragment>
				<EnvironmentDetails {...environment} />
				<Configurations {...environment} />
			</React.Fragment>
		)
	} else {
		return <p>...</p>
	}
}

function EnvironmentDetails(environment: any) {
	return (
		<div>
			<h1>{environment.id}</h1>
			<li>

			</li>
		</div>
	)
}

function Configurations(environment: any) {

	return (
		<React.Fragment>


		</React.Fragment>
	)
}

function ConfigurationsMarkup() {
	return (
	<React.Fragment>



	</React.Fragment>
	);
}

