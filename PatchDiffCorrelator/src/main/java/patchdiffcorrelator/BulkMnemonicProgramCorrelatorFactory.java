package patchdiffcorrelator;

import ghidra.feature.vt.api.main.VTProgramCorrelator;
import ghidra.feature.vt.api.util.VTOptions;
import ghidra.program.model.address.AddressSetView;
import ghidra.program.model.listing.Program;

public class BulkMnemonicProgramCorrelatorFactory extends AbstractBulkProgramCorrelatorFactory {
	static final String DESC = "Compares functions based on their included instruction mnemonics without taking the order of the instructions into account.";
	static final String NAME = "Bulk Mnemonics Match";
	
	@Override
	protected VTProgramCorrelator doCreateCorrelator(
			Program sourceProgram, AddressSetView sourceAddressSet, Program destinationProgram,
			AddressSetView destinationAddressSet, VTOptions options) {
		return new BulkProgramCorrelator(sourceProgram, sourceAddressSet,
			destinationProgram, destinationAddressSet, options, NAME, MnemonicFunctionBulker.INSTANCE);
	}
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESC;
	}
}
