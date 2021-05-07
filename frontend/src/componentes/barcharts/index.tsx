import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { SaleSucess } from 'types/sale';
import { round } from 'util/format';
import { BASE_URL } from 'util/Requests';

type SeriesData ={
    name: string;
    data: number[];
}

type CharData = {
    labels: {
        categories : string[];
    };
    series: SeriesData[];

}

function BarChart() {    
    const [charData, setCharData] = useState<CharData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "% Sucesso",
                data: []                   
            }
        ]    
    });
        
    useEffect( 
        () => {
              axios.get(`${BASE_URL}/sales/success-by-seller`)
                .then( (response) => {
            const data = response.data as SaleSucess[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map( x => round(100.0 * x.deals/x.visited,1));
            setCharData( { 
                labels: {
                    categories: myLabels
                },
                series: [
                    {
                        name: "% Sucesso",
                        data: mySeries                   
                    }
                ]
            }); 
        });
    }, []);
    
        
    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };
       
    return (        
          <Chart 
             options={{...options, xaxis: charData.labels}}
             series={charData.series} 
             type="bar"
             height="240"         
          />     
    );
}
export default BarChart;