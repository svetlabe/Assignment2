export class RestClient {

    static baseUrl = "http://localhost:8111"

    static async getEnvironments() : Promise<any> {
        const url = `${RestClient.baseUrl}/environments`
        const response = await window.fetch(url)
        return await response.json()
    }

    static async getEnvironment(id: number) : Promise<any> {
        const url = `${RestClient.baseUrl}/environments/${id}`
        const response = await window.fetch(url)
        return await response.json()
    }

    static addEnvironment(environment: any) : Promise<any> {
        const url = `${RestClient.baseUrl}/admin/environments`
        return window.fetch(
            url,
            {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json', 'Authorisation': 'ok' },
                body: JSON.stringify(environment)
            }
        )
    }


}