package by.htp.wa.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.wa.command.go.to.impl.GoToMain;
import by.htp.wa.command.go.to.impl.GoToRegistration;
import by.htp.wa.command.go.to.impl.GoToSignIn;
import by.htp.wa.command.go.to.impl.GoToTest;
import by.htp.wa.command.impl.AuthorizationCommand;
import by.htp.wa.command.impl.LocalizationCommand;
import by.htp.wa.command.impl.RegistrationCommand;
import by.htp.wa.command.impl.SignOut;
import by.htp.wa.command.impl.StartTest;
import by.htp.wa.command.impl.TestResult;

public final class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

	public CommandProvider() {
		commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
		commands.put(CommandName.REGISTRATION, new RegistrationCommand());
		commands.put(CommandName.LOCALIZATION, new LocalizationCommand());
		commands.put(CommandName.SIGN_OUT, new SignOut());
		commands.put(CommandName.START_TEST, new StartTest());
		commands.put(CommandName.TEST_RESULT, new TestResult());
		
		commands.put(CommandName.GO_TO_SIGN_IN, new GoToSignIn());
		commands.put(CommandName.GO_TO_MAIN, new GoToMain());
		commands.put(CommandName.GO_TO_REGISTRATION, new GoToRegistration());
		commands.put(CommandName.GO_TO_TEST, new GoToTest());
	}

	public Command getCommand(String name) {
		CommandName commandName;

		commandName = CommandName.valueOf(name.toUpperCase());

		return commands.get(commandName);
	}

}
