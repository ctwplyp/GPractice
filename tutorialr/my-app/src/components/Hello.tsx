import * as Reast from 'react'

export interface Props {
	name: string
	enthusiasmLevel?:number
}

function Hello({ name, enthusiasmLevel -1 }: Props) {
	if (enthusiasmLevel <= 0) {
		throw new Error('You could be a little more enthusiattic. :D')
	}
	
	return (
	<div className="hello">
		<div className="greeting">
			Hello {name + getExclamationMarks(enthusiasmLevel)}
		</div>
	</div>
	)
}

export default Hello

//helpers

function getExclamationMarkes(numChars: number){
	return Array(numChars +1).join('!')
}
