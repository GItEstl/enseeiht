/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.Optional;

/**
 * Interface to mark a node in the Abstract Syntax Tree as a Scope in the language.
 * @author Marc Pantel
 *
 */
public interface Scope <D extends Declaration> {
	
	/**
	 * @param _name : Name of the element looked for in the scope.
	 * @return : An optional object that carry an element named _name if there exists one in the scope, empty if not.
	 */
	public Optional<D> get(String _name);
	
	/**
	 * Check if an element is registered (contained) in the current scope.
	 * @param _name : Name of the element looked for in the current scope.
	 * @return : True if the scope contains an element named _name, false if not.
	 */
	public boolean contains(String _name);
	
	/**
	 * Check if a declaration can be registered in the scope.
	 * @param _declaration : _declaration which is checked.
	 * @return : True if the _declaration can be registered in the scope, false if not.
	 */
	public boolean accepts(D _declaration);
	
	/**
	 * Register a declaration in the scope.
	 * @param _declaration : _declaration that is registedred in the scope.
	 * @throws ForbiddenDeclarationException : Thrown if the _declaration element is not accepted in the scope.
	 */
	public void register(D _declaration) throws ForbiddenDeclarationException;

	
}
